package com.redeyes.registration.repository;

import com.redeyes.registration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User repository.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    /**
     * Logger for repository.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    /**
     * Row mapper for user.
     */
    private static final RowMapper<User> ROW_MAPPER = (rs, rowNum) ->
            new User(rs.getString("email"), rs.getString("password"), rs.getBoolean("is_confirmed"));

    /**
     * For query.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * For named query.
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public final void save(final User user) {
        LOG.info("Save :" + user);
        String sql = "INSERT INTO users(email, password, is_confirmed) VALUES(?,?,?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.isConfirmed());
        LOG.info("Saving success.");
    }

    @Override
    @Transactional(readOnly = true)
    public final User getByEmail(final String email) {
        LOG.info("Get user by email: {}", email);
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", ROW_MAPPER, email);
    }

    @Override
    public final void confirm(final String email) {
        LOG.info("Confirm user {}", email);
        getByEmail(email);
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("is_confirmed", true)
                .addValue("email", email);
        namedParameterJdbcTemplate.update(
                "UPDATE users SET is_confirmed=:is_confirmed WHERE email=:email", map);
        LOG.info("User confirmed.");
    }
}

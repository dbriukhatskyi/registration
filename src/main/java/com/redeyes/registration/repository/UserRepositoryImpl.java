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

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private static final RowMapper<User> ROW_MAPPER = (rs, rowNum) ->
            new User(rs.getString("email"), rs.getString("password"), rs.getBoolean("is_confirmed"));

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int save(User user) {
        LOG.info("Save :" + user);
        String sql = "INSERT INTO users(email, password, is_confirmed) VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.isConfirmed());
        LOG.info("Saving success.");
        return update;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("Get by email.");
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", ROW_MAPPER, email);
    }

    @Override
    public void confirm(User user) {
        LOG.info("Confirm user");
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("is_confirmed", true)
                .addValue("email", user.getEmail());
        namedParameterJdbcTemplate.update(
                "UPDATE users SET is_confirmed=:is_confirmed WHERE email=:email", map);
    }
}

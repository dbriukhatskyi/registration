$(document).ready(function () {

    $("#signup-button").on("click", function (e) {
        $("#reg-form").removeClass("invisible");
        $("#reg-button").addClass("invisible");
    });

    var form = $("#user-data");

    form.on("submit", function (e) {
        e.preventDefault();

        if (form.is(".loading")) {
            return false;
        }

        $.ajax({
            url: form.attr("action"),
            type: "post",
            data: form.serialize(),
            dataType: "json",
            timeout: 10000, // most people won't wait longer than 10 seconds
            success: function (response) {
                if (response.success) {
                    $("#message").text("");
                    $("body").load("sent.html", function () {
                        $('<audio autoplay="autoplay" style="display:none;">'
                            + '<source src="sound/ding.mp3" />'
                            + '<embed src="sound/ding.mp3" hidden="true" autostart="true"'
                            + 'loop="false" class="playSound" />'
                            + '</audio>').appendTo('body');
                    });
                } else {
                    $("#message").text(response.message);

                    if (response.invalidEmail) {
                        $("#email").addClass("error-field");
                        $("#email-message").text(response.emailMessage);
                    } else {
                        $("#email").removeClass("error-field");
                        $("#email-message").empty();
                    }

                    if (response.invalidPassword) {
                        $("#password").addClass("error-field");
                        $("#password-message").text(response.passwordMessage);
                    } else {
                        $("#password").removeClass("error-field");
                        $("#password-message").empty();
                    }
                }
            },
            error: function (e) {
                $("#message").text("Server not responding! Please, try again later." + e);
            }
        });
    });

    $(document).ajaxStart(function () {
        form.addClass("loading");
    });

    $(document).ajaxComplete(function () {
        form.removeClass("loading");
    });

});


$(function() {
    $('#login-form-link').click(function(e) {
        $("#login-form").show();
        $("#registration_form").hide();
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#registration_form").show();
        $("#login-form").hide();
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});

$().ready(function () {
    $("#registration_form").validate({
        rules: {
            reg_email: {
                required: true
            },
            reg_password: {
                required: true,
                minlength: 4
            },
            reg_confirm_password: {
                required: true,
                equalTo: "#reg_password"
            },
            last_name: {
                required: true
            },
            first_name: {
                required: true
            }

        },
        messages: {
            reg_email: {
                required: "E-mail address is not filled!",
            },
            reg_password: {
                required: "Password is not filled!",
                minlength: "Password has to be at least 5 characters long!"
            },
            reg_confirm_password: {
                required: "Confirm password is not filled!",
                equalTo: "Passwords are not matching!"
            },
            last_name: {
                required: "Last name is not filled"
            },
            first_name: {
                required: "First name is not filled!"
            }
        },
        errorElement: 'div',
        errorLabelContainer: '.errorDiv'
    })
});

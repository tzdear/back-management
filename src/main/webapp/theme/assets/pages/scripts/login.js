var Login = function() {

    var handleLogin = function() {

        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
            	userName: {
                    required: true
                },
                userPass: {
                    required: true
                },
                remember: {
                    required: false
                }
            },

            messages: {
            	userName: {
                    required: "用户名是必填项."
                },
                userPass: {
                    required: "密码是必填项."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit  
            	$('.alert-danger', $('.login-form')).find("span").html("请输入您的用户名和密码. ");
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
            	App.blockUI({"zIndex":1000});
            	var ctx = App.domain();
            	$('.login-form').attr("action",ctx+"/sys/login");
                form.submit(); // form validation success, call ajax form submit
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                	App.blockUI({"zIndex":1000});
                	var ctx = App.domain();
                	$('.login-form').attr("action",ctx+"/sys/login");
                    $('.login-form').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
    }

    var handleForgetPassword = function() {
        $('.forget-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
            	telPhone: {
                    required: true
                }
            },

            messages: {
            	telPhone: {
                    required: "手机号是必填项."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
            	App.blockUI({"zIndex":1000});
                form.submit();
            }
        });

        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                	App.blockUI({"zIndex":1000});
                    $('.forget-form').submit();
                }
                return false;
            }
        });

        jQuery('#forget-password').click(function() {
            jQuery('.login-form').hide();
            jQuery('.forget-form').show();
        });

        jQuery('#back-btn').click(function() {
            jQuery('.login-form').show();
            jQuery('.forget-form').hide();
        });

    }

    return {
        //main function to initiate the module
        init: function() {
            handleLogin();
            handleForgetPassword();
        }
    };

}();

jQuery(document).ready(function() {
    Login.init();
});
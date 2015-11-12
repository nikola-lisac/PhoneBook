$(function(){
	$.validator.setDefaults({
		errorClass: 'help-block',
		highlight: function(element) {

			$(element)
				.closest('.form-group')
				.addClass('has-error');
		},
		unhighlight: function(element) {
			$(element)
				.closest('.form-group')
				.removeClass('has-error');
		},
		errorPlacement: function(error, element) {
			if(element.prop('type') === 'radio') {
				error.insertAfter(element.parent().parent());
			}
			else {
				error.insertAfter(element);
			}
		}
	});

	$("#register").validate({
		rules: {
			username: {
				required: true,
				pattern: /^[a-zA-Z0-9]+$/
			},
			password: {
				required: true,
				pattern: /^[a-zA-Z0-9]+$/
			},
			passwordConfirm: {
				required: true,
				equalTo: "#password"
			},
			firstName: {
				required: true,
				lettersonly: true
			},
			lastName: {
				required: true,
				lettersonly: true
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			username: {
				required: 'Please enter the username',
				pattern: 'Only letters and digits are allowed'
			},
			password: {
				required: 'Please enter the password',
				pattern: 'Only letters and digits are allowed'
			},
			passwordConfirm: {
				required: 'Please re-enter the password'
			},
			firstName: {
				required: 'Please enter the first name',
				lettersonly: 'Please enter only letters'
			},
			lastName: {
				required: 'Please enter the last name',
				lettersonly: 'Please enter only letters'
			},
			email: {
				required: 'Please enter the email',
				email: 'Please enter a valid email'
			},
			
		}
	});

});
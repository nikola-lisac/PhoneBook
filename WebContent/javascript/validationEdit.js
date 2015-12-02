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

	$("#editPerson").validate({
		rules: {
			firstName: {
				required: true,
				lettersonly: true
			},
			lastName: {
				required: true,
				lettersonly: true
			},
			gender: {
				required: true
			},
			address: {
				required: true,
				pattern: /^[a-zA-Z0-9 /]+$/
			},
			city: {
				required: true,
				pattern: /^[a-zA-Z ]+$/
			},
			phone: {
				required: true,
				digits: true
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			firstName: {
				required: 'Please enter the first name',
				lettersonly: 'Please enter only letters'
			},
			lastName: {
				required: 'Please enter the last name',
				lettersonly: 'Please enter only letters'
			},
			address: {
				required: 'Please enter the address',
				pattern: 'Please enter only letters, numbers, spaces and forward slashes'
			},
			email: {
				required: 'Please enter the email',
				email: 'Please enter a valid email'
			},
			gender: {
				required: 'Please enter the gender'
			},
			city: {
				required: 'Please enter the city',
				pattern: 'Please enter only letters and spaces'
			}
		}
	});

});
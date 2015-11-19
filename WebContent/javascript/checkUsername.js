$(document).ready(function() {

	$("#username").blur(function() {

		var name = $("#username").val();

		$.ajax({
			url : "usernameCheck",
			method : "GET",
			data : {
				username : name
			}
		}).done(function(resp) {
			if(resp === 'true'){
				$("#usernameError").html("Username available").css("color","green");
			} else {
				$("#usernameError").html("Username is not available.");
			}
		});

	});
	
	
	
});

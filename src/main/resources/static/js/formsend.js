$(document).ready(function() {
	var form = $("#user-data");

	form.on("submit", function(e) {
		e.preventDefault();

		if (form.is(".loading, .success")) {
			return false;
		}

		$.ajax({
			url : form.attr("action"),
			type : "post",
			data : form.serialize(),
			dataType : "json",
			timeout : 30000,
			success : function(response) {
				if (response.success) {
					// 
				} else {
					$("#message").text(response.message);
					
					if (response.invalidEmail) {
						
					}
					
					if (response.invalidPassword) {
						$("#password").css("border-color", "red");
					}
				}
			},
			error : function(e) {
				$("#message").text("Server not responding! Please, try again later.");
			}
		});
	});

	$(document).ajaxStart(function() {
		form.addClass("loading");
	});

	$(document).ajaxComplete(function() {
		form.removeClass("loading");
	});
});
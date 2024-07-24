$(document).ready(function() {
    $('#register-form').submit(function(e) {
        e.preventDefault();
        $.ajax({
            url: '/process_register',
            type: 'POST',
            data: $(this).serialize(),
            success: function(response) {
                if (response === 'username_exists') {
                    showUsernameExistsDialog();
                } else {
                    // Handle success response
                }
            },
            error: function(error) {
                console.error(error);
            }
        });
    });
});

function showUsernameExistsDialog() {
    $("#usernameExistsModal").modal('show'); // Assuming you have a Bootstrap modal with an ID of "usernameExistsModal"
}

function validateForm() {
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;

            const regex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
            if (!regex.test(password)) {
                alert('Password must contain at least one uppercase letter, one number, and one special character.');
                return false;
            }

            if (password !== confirmPassword) {
                alert('Password and confirm password do not match.');
                return false;
            }

            return true;
        }
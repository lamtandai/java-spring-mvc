function initializePasswordValidation() {
    console.log('Initializing password validation');
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&+=]).{8,}$/;

    $('#password').on('input', function() {
        console.log('Input event triggered for password');
        const passwordValue = $(this).val().trim();
        const isValid = passwordRegex.test(passwordValue);
        const $feedbackContainer = $(this).closest('.mb-3').find('.invalid-feedback, .valid-feedback');

        if (passwordValue === '') {
            $(this).removeClass('is-invalid is-valid');
            $feedbackContainer.hide();
        } else if (!isValid) {
            $(this).removeClass('is-valid').addClass('is-invalid');
            $feedbackContainer.filter('.invalid-feedback').text('Password must contain at least 8 characters, including one lowercase letter, one uppercase letter, one number, and one special character');
            $feedbackContainer.filter('.invalid-feedback').show();
            $feedbackContainer.filter('.valid-feedback').hide();
        } else {
            $(this).removeClass('is-invalid').addClass('is-valid');
            $feedbackContainer.filter('.invalid-feedback').hide();
            $feedbackContainer.filter('.valid-feedback').show();
        }
    });
}

// Initialize validations when the document is ready
$(document).ready(function() {
    if ($('#password').length > 0) initializePasswordValidation();
    // Add other validations (fullName, phone) as needed
});
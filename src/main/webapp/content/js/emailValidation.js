// validation.js
function initializeEmailValidation() {
    
    const emailRegex = /^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // Matches server-side @Email

    $('#email').on('input', function() {
        console.log('Input event triggered for email');
        const emailValue = $(this).val().trim();
        const isValid = emailRegex.test(emailValue);
        const $feedbackContainer = $(this).closest('.mb-3').find('.invalid-feedback, .valid-feedback');

        if (emailValue === '') {
            $(this).removeClass('is-invalid is-valid');
            $feedbackContainer.hide();
        } else if (!isValid) {
            $(this).removeClass('is-valid').addClass('is-invalid');
            $feedbackContainer.filter('.invalid-feedback').show();
            $feedbackContainer.filter('.valid-feedback').hide();
        } else {
            $(this).removeClass('is-invalid').addClass('is-valid');
            $feedbackContainer.filter('.invalid-feedback').hide();
            $feedbackContainer.filter('.valid-feedback').show();
        }
    });
}

// Ensure this is called when the document is ready
$(document).ready(function() {
    if ($('#email').length > 0) initializeEmailValidation();
    // Other validations (fullName, phone, password) are already handled in previous responses
});
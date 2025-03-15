// validation.js
function initializeFullNameValidation() {
   
    const FullNameRegex = /^[a-zA-Z0-9 ]{10,}$/; // Matches server-side @FullName

    $('#fullName').on('input', function() {

        const FullNameValue = $(this).val().trim();
        const isValid = FullNameRegex.test(FullNameValue);
        const $feedbackContainer = $(this).closest('.mb-3').find('.invalid-feedback, .valid-feedback');

        if (FullNameValue === '') {
            $(this).removeClass('is-invalid is-valid');
            $feedbackContainer.hide();
        } else if (!isValid) {
            $(this).removeClass('is-valid').addClass('is-invalid');
            $feedbackContainer.filter('.invalid-feedback').text('Name Field must be at least 10 characters long, no special character, and number is allowed');
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
    if ($('#fullName').length > 0) initializeFullNameValidation();
    // Other validations (fullFullName, phone, password) are already handled in previous responses
});
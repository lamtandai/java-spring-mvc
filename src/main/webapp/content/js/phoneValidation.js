function initializePhoneValidation() {
    const phoneRegex = /^0\d{9}$/;
    $('#phone').on('input', function() {
        const phoneValue = $(this).val().trim();
        const $feedbackContainer = $(this).closest('.mb-3').find('.invalid-feedback, .valid-feedback');
        const isValid = phoneRegex.test(phoneValue);

        if (phoneValue === '') {
            $(this).removeClass('is-invalid is-valid');
            $feedbackContainer.hide();
        } else if (!isValid) {
            $(this).removeClass('is-valid').addClass('is-invalid');
            $feedbackContainer.filter('.invalid-feedback').text('Phone number must be 10 digits starting with 0');
            $feedbackContainer.filter('.invalid-feedback').show();
            $feedbackContainer.filter('.valid-feedback').hide();
        } else {
            $(this).removeClass('is-invalid').addClass('is-valid');
            $feedbackContainer.filter('.invalid-feedback').hide();
            $feedbackContainer.filter('.valid-feedback').show();
        }
    });
}
$(document).ready(function() {
    if ($('#password').length > 0) initializePhoneValidation();
    // Add other validations (fullName, phone) as needed
}); 
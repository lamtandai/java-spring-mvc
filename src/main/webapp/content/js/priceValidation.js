function initializePriceValidation() {
    const PriceRegex = /^(\+?\d+|-?0+)$/;
    $('#price').on('input', function() {
        const PriceValue = $(this).val().trim();
        const $feedbackContainer = $(this).closest('.mb-3').find('.invalid-feedback, .valid-feedback');
        const isValid = PriceRegex.test(PriceValue);

        if (PriceValue === '') {
            $(this).removeClass('is-invalid is-valid');
            $feedbackContainer.hide();
        } else if (!isValid) {
            $(this).removeClass('is-valid').addClass('is-invalid');
            $feedbackContainer.filter('.invalid-feedback').text('Price Value must be a non-negative number');
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
    if ($('#price').length > 0) initializePriceValidation();
    // Add other validations (fullName, Price) as needed
}); 
function initializeQuantityValidation() {
    const PriceRegex = /^(\+?\d+|-?0+)$/;
    $('#quantity').on('input', function() {
        const QuantityVal = $(this).val().trim();
        const $feedbackContainer = $(this).closest('.mb-3').find('.invalid-feedback, .valid-feedback');
        const isValid = PriceRegex.test(QuantityVal);

        if (QuantityVal === '') {
            $(this).removeClass('is-invalid is-valid');
            $feedbackContainer.hide();
        } else if (!isValid) {
            $(this).removeClass('is-valid').addClass('is-invalid');
            $feedbackContainer.filter('.invalid-feedback').text('Quantity Value must be a non-negative integer');
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
    if ($('#quantity').length > 0) initializeQuantityValidation();
    // Add other validations (fullName, Price) as needed
}); 
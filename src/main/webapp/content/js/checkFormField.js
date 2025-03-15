function checkFormFields() {
    console.log('Checking form fields...');

    // Get all required fields dynamically
    const requiredFields = $('[data-required="true"]');
    const fieldValues = {};

    // Collect values and log them
    requiredFields.each(function () {
        const fieldId = $(this).attr('id');
        const value = $(this).val() ? $(this).val().trim() : '';
        fieldValues[fieldId] = value;
    });

    console.log('Field values:', fieldValues);

    // Check if all required fields are non-empty
    const allFieldsFilled = requiredFields.toArray().every(field => $(field).val() && $(field).val().trim() !== '');

    console.log('All fields filled:', allFieldsFilled);

    const submitButton = $('#submitButton');
    if (allFieldsFilled) {
        submitButton.prop('disabled', false);
        submitButton.removeClass('btn-secondary').addClass('btn-primary');
        console.log('Submit button enabled');
    } else {
        submitButton.prop('disabled', true);
        submitButton.removeClass('btn-primary').addClass('btn-secondary');
        console.log('Submit button disabled');
    }
}

$(document).ready(function () {
    $('[data-required="true"]').on('input', function () {
        console.log('Input event triggered for:', $(this).attr('id'));
        checkFormFields();
    });

    // Initial check on page load
    checkFormFields();
    // Add other validations (fullName, phone) as needed
}); 
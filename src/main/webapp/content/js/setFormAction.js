function setFormAction(formId, actionUrl) {
    const form = document.getElementById(formId);
    
    if (!form) {
        console.error(`Form with ID ${formId} not found`);
        return;
    }
    form.action = actionUrl;
    form.submit();
}

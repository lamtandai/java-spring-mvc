function handleFilePreview(fileInputId, previewId) {
        const fileInput = $(`#${fileInputId}`);
        const previewImage = $(`#${previewId}`);

        fileInput.on('change', function(e) {
            if (e.target.files && e.target.files[0]) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                previewImage.attr('src', imgURL);
                previewImage.css({ "display": "block" });
            } else {
                previewImage.css({ "display": "none" });
            }
        });
}

function previewImage(imageFile,previewImage,imageURL, target){
    const avatarFile = imageFile;

    const oriImage = imageURL;
    if (oriImage) {
        const imgURL = "/images/" + target + "/" + oriImage;
        previewImage.attr("src", imgURL);
        previewImage.css({ "display": "block" });
    }
    avatarFile.change(function (e) {
        const imgURL = URL.createObjectURL(e.target.files[0]);
        previewImage.attr("src", imgURL);
        previewImage.css({ "display": "block" });
    });
}


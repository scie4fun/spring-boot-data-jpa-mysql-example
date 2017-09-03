$(document).ready(function () {
    setEditable();
});

function setEditable() {
    $('.edit').hide();
    $('.editable-cell').on('click', '.edit-btn', () => {
        $(this).find('.edit').show();
    });
}
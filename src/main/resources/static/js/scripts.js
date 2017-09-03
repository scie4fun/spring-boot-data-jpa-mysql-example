let selected = false;

$(document).ready(function () {
    addClickEvent();
});

function addClickEvent() {
    $(".editable-cell").on('click', function (e) {
        $(this).off('click');
        let cell = $(e.target);
        edit(cell);
    });
}

function edit(selector) {
    if (selected === false) {
        let cellText = $(selector).html();
        $(selector).html(getForm(cellText));
        selected = true;

        $('#selected').keydown(function (event) {
            let keyCode = (event.keyCode ? event.keyCode : event.which);
            if (keyCode === 13 && $('#selected').val() !== '') {
                let text = $('#selected').val();
                $(selector).text(text);
                selected = false;
                addClickEvent();
            }
        });
    }
}

function getForm(text) {
    return  '<input ' +
            'class=\"form-control\" ' +
            'value=\"' + text + '\" ' +
            'id=\"' + 'selected' + '\"' +
            '/>';
}

//https://stackoverflow.com/questions/17921647/jquery-form-submission-when-form-nested-in-table
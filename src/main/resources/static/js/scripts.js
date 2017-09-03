let selected = false;

$(document).ready(function () {
    addClickEvent();
});

function addClickEvent() {
    //1. Detect click on cell
    $("table.editable-table > tbody > tr > td").on('click', function (e) {
        $(this).off('click');
        let cell = $(e.target);
        edit(cell);
    });
}

function edit(selector) {
    if (selected === false) {
        let cellText = $(selector).html();
        $(selector).replaceWith(getForm(cellText));
        selected = true;

        $('#selected').keydown(function (event) {
            let keyCode = (event.keyCode ? event.keyCode : event.which);
            if (keyCode === 13) {
                let text = $('#selected').val();
                $('#selected').replaceWith(text);
                selected = false;
                addClickEvent();
            }
        });
    }
}

function getForm(text) {
    return form =
        '<td>' +
        '<input ' +
        'class=\"form-control\" ' +
        'value=\"' + text + '\" ' +
        'id=\"' + 'selected' + '\"' +
        '/>' +
        '</td>';
}

//https://stackoverflow.com/questions/17921647/jquery-form-submission-when-form-nested-in-table
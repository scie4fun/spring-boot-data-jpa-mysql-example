let selected = false;

$(document).ready(function () {
    addClickEvent();
    //getCurrentColumnName();
});

function getCurrentColumnName() {
    $('.editable-cell').on( 'click', function () {
        // alert($('#crud-table thead tr th').eq($(this).index().html().trim()));
        alert($('#crud-table thead tr th').eq($(this).index()).text());
    });
}

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
                /*let text = $('#selected').val();
                $(selector).text(text);*/
                this.form.submit();
                selected = false;
                addClickEvent();
            }
        });
    }
}

function getForm(text) {
    return  '<input ' +
            'name=\"edit\" th:type=\"submit\"' +
            'class=\"form-control\" ' +
            'value=\"' + text + '\" ' +
            'id=\"' + 'selected' + '\"' +
            '/>';
}

//https://stackoverflow.com/questions/17921647/jquery-form-submission-when-form-nested-in-table
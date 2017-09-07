var UINestable = function () {

    var updateOutput = function (e) {
        
    };


    return {
        //main function to initiate the module
        init: function () {

            // activate Nestable for list 1
            $('#nestable_list_1').nestable({
                group: 1
            })
               


        }

    };

}();

jQuery(document).ready(function() {    
   UINestable.init();
});
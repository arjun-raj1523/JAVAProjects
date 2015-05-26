var events = function(){
	
	$("input[name='IterationStartDate']").datepicker({
       numberOfMonths: 1,
	   beforeShowDay: $.datepicker.noWeekends,
        onSelect: function(selected) {
          $("input[name='IterationEndDate']").datepicker("option","minDate", selected)
        }
   });
   
    $("input[name='IterationEndDate']").datepicker({
       numberOfMonths: 1,
	   beforeShowDay: $.datepicker.noWeekends,
	    onSelect: function(selected) {
        $("input[name='IterationStartDate']").datepicker("option","maxDate", selected)
		}
	}); 
    
    
    $("input[name='ReleaseStartDate']").datepicker({
        numberOfMonths: 1,
 	   beforeShowDay: $.datepicker.noWeekends,
 	    onSelect: function(selected) {
         $("input[name='ReleaseReleaseDate']").datepicker("option","minDate", selected)
         $("input[name='ReleasePlannedDate']").datepicker("option","minDate", selected)
 		}
 	});
    
    $("input[name='ReleasePlannedDate']").datepicker({
        numberOfMonths: 1,
 	   beforeShowDay: $.datepicker.noWeekends,
 	    onSelect: function(selected) {
         $("input[name='ReleaseStartDate']").datepicker("option","maxDate", selected)
 		}
 	});
    
    $("input[name='ReleaseReleaseDate']").datepicker({
        numberOfMonths: 1,
 	   beforeShowDay: $.datepicker.noWeekends,
 	    onSelect: function(selected) {
         $("input[name='ReleaseStartDate']").datepicker("option","maxDate", selected)
 		}
 	});
};
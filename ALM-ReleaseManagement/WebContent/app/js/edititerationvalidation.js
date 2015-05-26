

function alphanumeric()
{
		//var form 
		var title = $("form input[name='title']").val();
		var description = $("form input[name='description']").val();
		var items=  $("form input[name='items']").val();
		
		
	
	var passw=  	/^[A-Za-z][A-Za-z0-9]{4,19}$/;  
	var passw1=  	/^[A-Za-z][A-Za-z0-9]{19,99}$/;
	var passw2=  	/^[A-Za-z][A-Za-z0-9]{9,24}$/;
	if(!title.match(passw))  
	{
		alert('wrong title given !');
		return false;
	}
	else if(!description.match(passw1))
	{
		alert('wrong description');
		return false;
	} 
	else if(!items.match(passw2))
	{
	alert('items field entered wrong');
	return false;
	}
	
	alert('correct');
	return true;
}

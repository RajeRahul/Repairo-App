function atLeastOneChecked() {
  var serviceCheckboxes = document.getElementsByClassName("service-chk");
  var locationCheckboxes = document.getElementsByClassName("location-chk");
  var serviceCheck = false;
  var locationCheck = false;

  for(var i=0,l=serviceCheckboxes.length;i<l;i++) {
      if(serviceCheckboxes[i].checked) {
          serviceCheck=true;
          break;
      }
  }
  for(var i=0,l=locationCheckboxes.length;i<l;i++) {
      if(locationCheckboxes[i].checked) {
          locationCheck=true;
          break;
      }
  }

  if(serviceCheck==false && locationCheck==true) {
    alert("Please select at least one type of service.");
    return false;
  } else if(serviceCheck==true && locationCheck==false) {
    alert("Please select at least one Location");
    return false;
  } else if(serviceCheck==false && locationCheck==false) {
    alert("Please select from the given options");
    return false;
  } else {
    return true;
  }

}

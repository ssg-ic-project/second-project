function checkAll(el){
  const checkBoxes  = document.querySelectorAll('.check-box');
  checkBoxes.forEach((row)=>{
    row.checked = el.checked;
  })
}

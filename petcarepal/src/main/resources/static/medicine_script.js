document.addEventListener("DOMContentLoaded", function() {
  const boxes = document.querySelectorAll('.box');
  let currentIndex = 0;

  function moveNext() {
    currentIndex = (currentIndex + 1) % boxes.length;
    const newTransform = `translateX(-${currentIndex * 100}%)`;
    boxes.forEach(box => {
      box.style.transform = newTransform;
    });
  }

  setInterval(moveNext, 8000); // Adjust timing here (milliseconds)
});

// To reload the Page
function reload(){
  window.location.reload();
}
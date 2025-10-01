let image = document.querySelector(".slider-image");

let translate = 0;

setInterval(() => {
  if (translate >= 0 && translate < 200) {
    translate += 100;
  } else {
    translate = 0;
  }
  image.style.transition = "2s";
  image.style.transform = `translateX(${-translate}%)`;
}, 4000);

function right() {
  if (translate < 200) {
    image.style.transform = `translateX(${-translate}%)`;
    image.style.transition = "1s";
    translate += 100;
  }
}
function left() {
  if (translate > 0) {
    image.style.transform = `translateX(${-translate}%)`;
    image.style.transition = "1s";
    translate -= 100;
  }
  console.log("ji");
}
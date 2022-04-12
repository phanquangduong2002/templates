const imageShow = document.querySelector('.image-show .img img')
const imageList = document.querySelectorAll('.image-item img')
const divImageList = document.querySelectorAll('.image-item')
const nextBtn = document.querySelector('.next')
const prevBtn = document.querySelector('.prev')
let currentIndex = 0

function handleActive() {
    divImageList.forEach(div => {
        div.classList.remove('active')
    })
    divImageList[currentIndex].classList.add('active')
}

function nextImage() {
    currentIndex++
    if(currentIndex === imageList.length) currentIndex = 0
    imageShow.src = imageList[currentIndex].src
    handleActive()
}
function prevImage() {
    currentIndex--
    if(currentIndex < 0) currentIndex = imageList.length - 1
    imageShow.src = imageList[currentIndex].src
    handleActive()
}

nextBtn.addEventListener('click', nextImage)

prevBtn.addEventListener('click', prevImage)
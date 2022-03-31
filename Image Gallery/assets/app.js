const images = document.querySelectorAll('.image img')
const gallery = document.querySelector('.gallery')
const imageShow = document.querySelector('.image-show img')
const closeBtn = document.querySelector('.close')
const nextBtn = document.querySelector('.next')
const prevBtn = document.querySelector('.prev')

let currentIndex = 0;

function showImage(index) {
    currentIndex = index;
    imageShow.src = images[currentIndex].src
    gallery.classList.add('show')
}

function hideImage() {
    gallery.classList.remove('show')
}

function nextImage() {
    currentIndex++
    if(currentIndex === images.length) currentIndex = 0
    imageShow.src = images[currentIndex].src
}

function prevImage() {
    currentIndex--
    if(currentIndex < 0) currentIndex = images.length - 1
    imageShow.src = images[currentIndex].src
}


images.forEach((image, index) => {
    image.addEventListener('click', () => showImage(index))
})

closeBtn.addEventListener('click', hideImage)

nextBtn.addEventListener('click', nextImage)

prevBtn.addEventListener('click', prevImage)

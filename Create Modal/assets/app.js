
const modalContainer = document.querySelector('.modal-container')
const modalInner = modalContainer.querySelector('.modal-inner')
const openBtn = document.querySelector('.open-modal-btn')
const closeBtn = modalContainer.querySelector('.modal-close')

function toggleModal() {
    modalContainer.classList.toggle('open')
}

openBtn.addEventListener('click', toggleModal)
modalContainer.addEventListener('click', toggleModal)
closeBtn.addEventListener('click', toggleModal)

modalInner.addEventListener('click', function(e) {
    e.stopPropagation()
})

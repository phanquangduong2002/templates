const btns = document.querySelectorAll('.food-menu button')
const foodList = document.querySelectorAll('.food-item')

btns.forEach(btn => {
    btn.addEventListener('click', e => {
        const type = e.target.getAttribute('type')
        document.querySelector('button.active').classList.remove('active')
        e.target.classList.add('active')
        foodList.forEach(item => {
            if(type === 'all' || item.getAttribute('type') === type) {
                item.classList.remove('hide')
            } else {
                item.classList.add('hide')
            }
        })
    })
})


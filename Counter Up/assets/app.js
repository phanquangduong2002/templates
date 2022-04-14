const fb = document.querySelector('.facebook h2')
const youtube = document.querySelector('.youtube h2')
const tiktok = document.querySelector('.tiktok h2')

function counterUp(el, to) {
    let count = 0
    const time = 100
    const step = to / time
    const counterUpId = setInterval(() => {
        count += step
        if(count > to) {
            clearInterval(counterUpId)
            el.innerText = to
        } else {
            el.innerText = count
        }
    }, 10)
}

counterUp(fb, 3300)
counterUp(youtube, 1000)
counterUp(tiktok, 9900)
function toast({
    msg,
    type
}) {
    const main = document.querySelector('#toast')
    const toast = document.createElement('div')
    const icons = {
        success: 'fa-solid fa-circle-check',
        error: 'fa-solid fa-triangle-exclamation',
        warning: 'fa-solid fa-circle-exclamation'
    }
    const icon = icons[type]

    toast.classList.add('toast', `toast--${type}`)
    toast.innerHTML = `
            <div class="toast__icon">
                <i class="${icon}"></i>
            </div>
            <div class="toast__body">
                <p class="toast__msg">${msg}</p>
            </div>
            <div class="toast__close">
                <i class="fa-solid fa-xmark"></i>
            </div>
        `
    main.appendChild(toast)
    const removeToastId = setTimeout(function() {
        main.removeChild(toast)
    }, 4000)
    toast.onclick = function(e) {
        if(e.target.closest('.toast__close')) {
            main.removeChild(toast)
            clearTimeout(removeToastId)
        }
    }
}

function showSuccessToast() {
    toast({
        msg: 'This is a success message !',
        type: 'success'
    })
}

function showErrorToast() {
    toast({
        msg: 'This is a error message !',
        type: 'error'
    })
}

function showWarningToast() {
    toast({
        msg: 'This is a warning message !',
        type: 'warning'
    })
}
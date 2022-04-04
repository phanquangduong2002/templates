const searchBox = document.querySelector('.search-box')
const searchBtn = document.querySelector('.search-btn')
const searchInput = document.querySelector('.search-input')

function handleSearch() {
    searchBox.classList.toggle('show-box')
    searchInput.focus()
}

searchBtn.addEventListener('click', handleSearch)
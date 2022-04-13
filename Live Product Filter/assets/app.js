const products = document.querySelector('.products')
const filter = document.getElementById('filter')
const listItem = []

getData()

filter.oninput = function(e) {
    filterData(e.target.value)
}

async function getData() {
    const res = await fetch('https://fakestoreapi.com/products')
    const result = await res.json()

    result.forEach(item => {
        const div = document.createElement('div')
        div.classList.add('product-item')

        div.innerHTML = `
            <img src="${item.image}" alt="">
            <div class="product-item__detail">
                <h4>${item.title}</h4>
                <p>$${item.price}</p>
            </div>
        `

        listItem.push(div)
        products.appendChild(div)
    })
}

function filterData(search) {
    listItem.forEach(item => {
        if(item.innerText.toLowerCase().includes(search.toLowerCase())) {
            item.classList.remove('hide')
        } else {
            item.classList.add('hide')
        }
    })
}


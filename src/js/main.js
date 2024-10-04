const URL = 'http://localhost:8080';
let ownerList = [];
let typeList = [];
let petList = [];
let pet = {};

const findAllPets = async () => {
    await fetch(`${URL}/api/pet`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    }).then(response => response.json()).then(response => {
        console.log(response);
        petList = response.data;
    }).catch(console.log);
}

(async () => {
    await findAllPets();

    let tbody = document.getElementById('tbody');
    let content = '';
    petList.forEach((item, index) => {
        content += `<tr>
                        <th scope="row">${index + 1}</th>
                        <td>${item.nickname}</td>
                        <td>${item.owner.fullName}</td>
                        <td>${item.type.name}</td>
                        <td class="text-center">
                            <button class="btn btn-outline-danger">Eliminar</button>
                            <button class="btn btn-outline-primary">Editar</button>
                        </td>
                    </tr>`;
    });
    tbody.innerHTML = content;
})();

const findAllOwners = async () => {
    await fetch(`${URL}/api/owner`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    }).then(response => response.json()).then(response => {
        console.log(response);
        ownerList = response.data;
    }).catch(console.log);
}

const findAllTypes = async () => {
    await fetch(`${URL}/api/type`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    }).then(response => response.json()).then(response => {
        console.log(response);
        typeList = response.data;
    }).catch(console.log);
}

const loadData = async () => {
    await findAllOwners();
    await findAllTypes();

    let ownerSelect = document.getElementById('ownerList');
    let typeSelect = document.getElementById('typeList');
    let content = '';
    ownerList.forEach(item => {
        content += `<option value="${item.id}">${item.fullName}</option>`;
    });
    ownerSelect.innerHTML = content;

    content = '';
    typeList.forEach(item => {
        content += `<option value="${item.id}">${item.name}</option>`;
    });
    typeSelect.innerHTML = content;
}

const savePet = async () => {
    pet = {
        nickname: document.getElementById('nickname').value,
        owner: {
            id: document.getElementById('ownerList').value
        },
        type: {
            id: document.getElementById('typeList').value
        }
    };

    await fetch(`${URL}/api/pet`, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(pet)
    }).then(response => response.json()).then(response => {
        console.log(response);
        pet = {};
    }).catch(console.log);
}
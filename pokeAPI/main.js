const API_URL = "https://pokeapi.co/api/v2/pokemon";
const container = document.querySelector('.container');
const searchForm = document.querySelector('#search-form');

fetch(API_URL)
  .then(response => {
    if (!response.ok) {
      throw new Error('Hubo un problema al obtener los datos.');
    }

    return response.json();
  })
  .then(data => {
    data.results.forEach(pokemon => {
      fetch(pokemon.url)
        .then(response => response.json())
        .then(data => mostrarPokemones(data))
        .catch(error => console.error(('Hubo un error', error.message)))
    })
  })
  .catch(error => console.error(('Hubo un error', error.message)));

  function limpiarContenedor() {
    container.innerHTML = '';
  }

function mostrarPokemones(pokemon) {
  console.log(pokemon.types[0].type.name);
  console.log(pokemon.types[0]);
  
  container.innerHTML +=
    `<article class="pokemon">
        <div class="img-container">
          <span class=${pokemon.types[0]?.type.name}></span>
          <img src=${pokemon.sprites.other.dream_world.front_default} alt="">
        </div>
        <div class="pokemon-content">
          <h2>${pokemon.name}</h2>
          <p>
            <span class=${pokemon.types[0]?.type.name}>${pokemon.types[0]?.type.name}</span> 
            ${pokemon.types[1]?.type.name ? `<span class=${pokemon.types[1]?.type.name}>${pokemon.types[1]?.type.name}</span>` : ''} 
          </p>
          <button class="habilidades" data-name="${pokemon.name}">Ver habilidades</button>
        </div>
      </article>`;

      
      document.querySelectorAll('.habilidades').forEach(button => {
        button.addEventListener('click', manejoHabilidades);
      });
}

function manejoHabilidades(e){
  e.preventDefault();
  const pokemonName = e.target.dataset.name;
  mostrarHabilidades(pokemonName);

}
function mostrarPokemonesPorMovimiento(data) {
  // data.pokemon es la lista de Pokémon que tienen esa habilidad
  data.pokemon.forEach(pokemon => {
    fetch(pokemon.pokemon.url)
      .then(response => response.json())
      .then(data => mostrarPokemones(data))
      .catch(error => console.error(('Hubo un error', error.message)))
  })
}


// buscador
function buscarPokemon(e) {
  e.preventDefault()

  const search = document.querySelector('#search').value.trim().toLowerCase();
  const searchType = document.querySelector('select').value.toLowerCase();

  limpiarContenedor();
  if (searchType == 'name') {
    fetch(`https://pokeapi.co/api/v2/pokemon/${search}/`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Hubo un problema al obtener los datos.');
        }

        return response.json();
      })
      .then(data => {
        mostrarPokemones(data)
      })
      .catch(error => console.error(('Hubo un error', error.message)))
  } else if (searchType == 'ability') {
    fetch(`https://pokeapi.co/api/v2/ability/${search}/`)
      .then(response => {
        if (!response.ok) {
          console.log("error ");
          throw new Error('Hubo un problema al obtener los datos.');
          
        }
        return response.json();
        
      })
      .then(data => {
        console.log(data);
        mostrarPokemonesPorMovimiento(data);
      })
      .catch(error => console.error(('Hubo un error', error.message)))
  }
}

//Boton habilidades
function mostrarHabilidades(pokemonName) {
  fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`)
    .then(response => response.json())
    .then(data => {
      const abilities = data.abilities.map(ability => ability.ability.name).join(', ');
      alert(`Las habilidades de ${pokemonName} son: ${abilities}`);
    })
    .catch(error => console.error(('Hubo un error', error.message)))
}
searchForm.addEventListener('submit', buscarPokemon);


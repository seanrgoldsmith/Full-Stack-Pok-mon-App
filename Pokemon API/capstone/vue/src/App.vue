<template>
  <div id="app">
    <div id="nav">
      <router-link class="nav_button" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="nav_button" v-bind:to="{name: 'pokemon'}">Pokemon</router-link>&nbsp;|&nbsp;
      <router-link class="nav_button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      
      
    </div>
    <router-view />
  </div>
</template>

<style>
#app{
 
  background-color: #24231E;
  color: #AEAA46;
  background-image: url('assets/pokeBackground.jpg');
  margin: auto;
  width: 900px;
  height: 600px;
}
#nav{
  display: flex;
  background-color: rgb(223, 196, 48);
  justify-content: center;
  margin: 20px;
  font-family: 'Belanosima', sans-serif;
  background: linear-gradient(90deg, rgb(29, 28, 36) 0%, rgba(103,106,0,1) 42%, rgba(254,255,0,0.80) 91%);

}
.nav_button {
  background-color: rgb(211, 123, 7);
  height: 30px;
  width: 100px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  text-decoration: none;
  border: black solid 2px;
  color: aliceblue;
  border-radius: 15px;
  background: linear-gradient(90deg, rgb(29, 28, 36) 0%, rgb(192, 121, 40) 42%, rgba(243, 198, 0, 0.8) 91%);
}
</style>

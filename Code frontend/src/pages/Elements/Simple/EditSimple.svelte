<script>
  import axios from "axios";

  export let params = {};

  let id;

  $: {
    // "Reactive Statement":
    // This block of is executed whenever the value of a variable in it changes.
    // See https://svelte.dev/tutorial/reactive-statements
    id = params.id;
    getSimple();
    getElement();
  }

  // Teil für Simple
  let simple = {
    value: "",
  };

  function getSimple() {
    axios.get("http://localhost:8080/simple/" + id).then((response) => {
      simple = response.data;
    });
  }

  function updateSimple() {
    axios
      .put("http://localhost:8080/simple/update/" + id, simple)
      .then((response) => {
        console.log("erfolg");
      });
  }

  //Teil für Element

  let element = {
    name: "",
  };

  function getElement() {
    axios.get("http://localhost:8080/elements/" + id).then((response) => {
      element = response.data;
    });
  }

  function updateElement() {
    axios
      .put("http://localhost:8080/element/update/" + id, element)
      .then((response) => {
        console.log("erfolg e");
      });
  }

  function deleteElement() {
    axios
      .delete("http://localhost:8080/element/delete/" + id)
      .then((response) => {
        alert("Simple gelöscht");
      });
  }
</script>

<a href="#/simple"
  ><button class="btn btn-cancel" type="button">
    <i class="fas fa-times" /> cancel
  </button></a
>

<a href="#/simple"
  ><button
    on:click={updateSimple}
    on:click={updateElement}
    class="btn btn-success"
    type="button"
  >
    <i class="fas fa-save" /> speichern
  </button></a
>

<a href="#/simple"
  ><button on:click={deleteElement} class="btn btn-delete" type="button">
    <i class="fas fa-times" /> löschen
  </button></a
>

<div class="col-8">
  <h1 class="mt-3">Domain (ID: {id})</h1>
</div>

<form>
  <div class="mb-3">
    <label for="disabledTextInput" class="form-label">Name:</label>
    <input type="text" class="form-control" bind:value={element.name} />
  </div>
  <div class="mb-3">
    <label for="disabledTextInput" class="form-label">Value:</label>
    <input type="text" class="form-control" bind:value={simple.value} />
  </div>
</form>

<script>
    import axios from "axios";
  
    export let params = {};
  
    let id;
  
    $: {
      // "Reactive Statement":
      // This block of is executed whenever the value of a variable in it changes.
      // See https://svelte.dev/tutorial/reactive-statements
      id = params.id;
      getComplex();
      getElement();
    }
  
    // Teil für Complex
    let complex = {
        type: "",
    };
  
    function getComplex() {
      axios.get("http://localhost:8080/complex/" + id).then((response) => {
        complex = response.data;
      });
    }
  
    function updateComplex() {
      axios
        .put("http://localhost:8080/complex/update/" + id, complex)
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
          alert("Complex gelöscht");
        });
    }
  </script>
  
  <a href="#/complex"
    ><button class="btn btn-cancel" type="button">
      <i class="fas fa-times" /> cancel
    </button></a
  >
  
  <a href="#/complex"
    ><button
      on:click={updateComplex}
      on:click={updateElement}
      class="btn btn-success"
      type="button"
    >
      <i class="fas fa-save" /> speichern
    </button></a
  >
  
  <a href="#/complex"
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
      <label for="disabledTextInput" class="form-label">Type:</label>
      <input type="text" class="form-control" bind:value={complex.type} />
    </div>
  </form>
  
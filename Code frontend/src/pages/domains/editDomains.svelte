<script>
    import axios from "axios";
  
    export let params = {};
  
    let id;
  
    $: {
      // "Reactive Statement":
      // This block of is executed whenever the value of a variable in it changes.
      // See https://svelte.dev/tutorial/reactive-statements
      id = params.id;
      getDomain();
    }
  
    let domain = {
    name: "",
    ip: ""
  };
  
    function getDomain() {
      axios.get("http://localhost:8080/domains/" + id).then((response) => {
        domain = response.data;
      });
    }
  
    function updateDomain() {
      axios
        .put("http://localhost:8080/domains/update/" + id, domain)
        .then((response) => {
          console.log("erfolg");
        });
    }
  
    function deleteDomain(){
      axios.delete("http://localhost:8080/domains/del/" + id,).then((response) => {alert("Domain gelöscht");});
    }
  </script>
  
  
  <a href="#/domains"
    ><button class="btn btn-cancel" type="button">
      <i class="fas fa-times" /> cancel
    </button></a
  >
  
  <a href="#/domains"
    ><button on:click={updateDomain} class="btn btn-success" type="button">
      <i class="fas fa-save" /> speichern
    </button></a
  >
  
  <a href="#/domains"
    ><button on:click={deleteDomain} class="btn btn-delete" type="button">
      <i class="fas fa-times" /> löschen
    </button></a
  >
  
  
  
  <div class="col-8">
    <h1 class="mt-3">Domain (ID: {id})</h1>
  </div>
  
  <form>
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">Name:</label>
      <input type="text" class="form-control" bind:value={domain.name} />
    </div>

  
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">IP</label>
      <input type="text" class="form-control" bind:value={domain.ip} />
    </div>
  </form>
  
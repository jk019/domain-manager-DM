<script>
    import axios from "axios";
  
    let simple = {
      id: "",
      name: "", 
      parent: null,
      dtype: "simple",
      value: ""
    };
  
    function addSimple() {
      axios
        .post("http://localhost:8080/simple/create", simple)
        .then((response) => {
          alert("Simple hinzugefügt");
        })
        .catch((error) => {
          console.log(error);
          alert(error);
        });
    }
  </script>
  
  <button class="btn btn-secondary" type="button" onclick="history.back()">
    <i class="fas fa-arrow-left" /> Zurück
  </button>
  <h1 class="mt-3">Füge ein Simple-Element hinzu</h1>
  
  <form>
    <div class="mb-3">
      <label for="" class="form-label">ID</label>
      <input class="form-control" type="number" bind:value={simple.id} />
    </div>
  
    <div class="mb-3">
      <label for="" class="form-label">Name</label>
      <input class="form-control" type="text" bind:value={simple.name} />
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Value</label>
        <input class="form-control" type="text" bind:value={simple.value} />
      </div>
  
    <a href="#/elements"
      ><button on:click={addSimple} type="button" class="btn btn-secondary">
        Simple hinzufügen
      </button></a
    >
  </form>
  
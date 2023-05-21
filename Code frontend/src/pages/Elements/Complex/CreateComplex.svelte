<script>
  import axios from "axios";

  let complex = {
    id: "",
    name: "",
    parent: null,
    dtype: "complex",
    type: "",
  };

  function addComplex() {
    axios
      .post("http://localhost:8080/complex/create", complex)
      .then((response) => {
        alert("complex hinzugefügt");
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
<h1 class="mt-3">Füge ein Complex-Element hinzu</h1>

<form>
  <div class="mb-3">
    <label for="" class="form-label">ID</label>
    <input class="form-control" type="number" bind:value={complex.id} />
  </div>

  <div class="mb-3">
    <label for="" class="form-label">Name</label>
    <input class="form-control" type="text" bind:value={complex.name} />
  </div>
  <div class="mb-3">
    <label for="" class="form-label">Type</label>
    <select
          class="form-select"
          id="inputGroupSelect01"
          bind:value={complex.type}>
            <option value="basic">basic</option>
            <option value="personal">personal</option>
            <option value="professional">professional</option>
        </select>
  </div>

  <a href="#/elements"
    ><button on:click={addComplex} type="button" class="btn btn-secondary">
      Complex hinzufügen
    </button></a
  >
</form>

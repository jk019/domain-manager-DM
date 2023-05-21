<script>
  import axios from "axios";

  let domain = {
    name: "",
    ip: ""
  };

  function addDomain() {
    axios
      .post("http://localhost:8080/domains/create", domain)
      .then((response) => {
        alert("Domain hinzugefügt");
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
<h1 class="mt-3">Füge eine Domain hinzu</h1>

<form>
  <div class="mb-3">
    <label for="" class="form-label">Name</label>
    <input class="form-control" type="text" bind:value={domain.name} />
  </div>

  <div class="mb-3">
    <label for="" class="form-label">IP</label>
    <input class="form-control" type="text" bind:value={domain.ip} />
  </div>

  <a href="#/domains"
    ><button on:click={addDomain} type="button" class="btn btn-secondary">
      Domain hinzufügen
    </button></a
  >
</form>

<script>
  import axios from "axios";

  $: {
    getDomain();
  }

  let domain_id;
  let element_id;

  let document = {
    id: 0,
    creation_date: "2023-01-16",
    domain: null,
    element: null,
  };

  function addDocument() {
    axios
      .post("http://localhost:8080/document/create", document)
      .then((response) => {
        alert("Document hinzugefügt");
      })
      .catch((error) => {
        console.log(error);
        alert(error);
      });
  }

  function getDomain() {
    axios.get("http://localhost:8080/domains/" + domain_id).then((response) => {
      document.domain = response.data;
    });
  }

  function getElement() {
    axios.get("http://localhost:8080/elements/" + element_id).then((response) => {
      document.element = response.data;
    });
  }

  function zeig(){
    console.log(document)
  }
  
</script>

<button class="btn btn-secondary" type="button" onclick="history.back()">
  <i class="fas fa-arrow-left" /> Zurück
</button>
<h1 class="mt-3">Füge ein Document hinzu</h1>

<form>
  <div class="mb-3">
    <label for="" class="form-label">ID</label>
    <input class="form-control" type="text" bind:value={document.id} />
  </div>

  <div class="mb-3">
    <label for="" class="form-label">Domain-ID</label>
    <input class="form-control" type="text" bind:value={domain_id} />
  </div>

  <div class="mb-3">
    <label for="" class="form-label">Element-ID</label>
    <input class="form-control" type="text" bind:value={element_id} />
  </div>

  <!-- <a href="#/documents"
    > --><button on:click={getDomain} on:click={getElement}  on:click={addDocument} on:click={zeig} type="button" class="btn btn-secondary">
      Domain hinzufügen
    </button><!-- </a
  > -->
</form>

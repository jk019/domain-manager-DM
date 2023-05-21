<script>
  import axios from "axios";

  let simple = [];
  let selectedValue;
  let select2;

  function getSimple() {
    axios.get("http://localhost:8080/simple/all").then((response) => {
      simple = response.data;
      console.log(response.data);
    });
  }
  getSimple();
</script>

<div class="mb-5">
  <h1 class="mt-3">Liste aller Simple</h1>

  <!--  <a href="#/create-product"
        ><button class="btn btn-success" type="button">
          <i class="fas fa-plus" /> Element hinzufügen
        </button></a
      > -->
  <div class="row">
    <div class="col">
      <select
        class="form-select"
        aria-label="Default select example"
        bind:value={selectedValue}
        ><option value="#/simple">Liste aller Simple</option>
        <option value="#/elements">Liste aller Elemente</option>
        <option value="#/complex">Liste aller Complex</option>
      </select>
    </div>
    <div class="col">
      <a href={selectedValue}>
        <button type="button" class="btn btn-secondary">filtern</button></a
      >
    </div>

    <a href={selectedValue}>
      <button
        type="button"
        class="btn btn-warning"
        data-bs-toggle="modal"
        data-bs-target="#exampleModal">Element hinzufügen</button
      ></a
    >
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Value</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        {#each simple as element}
          <tr>
            <td>
              {element.id}
            </td>
            <td>
              {element.name}
            </td>
            <td>
              {element.value}
            </td>
            <td><div class="abstand">
              <a href={"#/simple/edit/"+element.id}
                ><button class="btn btn-warning" type="button">
                  <i class="fas fa-edit" />
                </button></a
              >
            </div></td>
          </tr>
        {/each}
      </tbody>
    </table>
  </div>
</div>


<div
  class="modal fade"
  id="exampleModal"
  tabindex="-1"
  aria-labelledby="exampleModalLabel"
  aria-hidden="true"
>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">
          Element hinzufügen
        </h1>
        <button
          type="button"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
        />
      </div>
      <div class="modal-body">
        
      </div>

      <div class="modal-body">
        <p>Bitte Wählen, welche Art des Elementes hinzugefügt werden soll</p>
        

        <select
          class="form-select"
          id="inputGroupSelect01"
          bind:value={select2}>
            <option value="complex">Complex</option>
            <option value="simple">Simple</option>
        </select>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"
          >Close</button
        ><a href={"#/create-" + select2}
          ><button type="button" class="btn btn-primary">Save changes</button>
        </a>
      </div>
    </div>
  </div>
</div>

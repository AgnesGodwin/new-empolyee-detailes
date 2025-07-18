document.getElementById("employeeForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const formData = new FormData(this);

  const response = await fetch("insert.php", {
    method: "POST",
    body: formData
  });

  const result = await response.json();
  alert(result.message);
  if (result.success) {
    this.reset();
  }
});

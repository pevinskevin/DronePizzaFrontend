document.addEventListener('DOMContentLoaded', function() {
    function fetchDeliveries() {
        fetch('http://localhost:8080/deliveries')
            .then(response => response.json())
            .then(data => {
                const rows = document.getElementById('table').getElementsByTagName('tr');

                data.forEach((delivery, index) => {
                    const row = rows[index];
                    const droneId = row.cells[2]; //

                    const currentDroneId = droneId.textContent;
                    const newDroneId = delivery.drone.id;

                    if (currentDroneId !== newDroneId) {
                        droneId.textContent = newDroneId;
                    }
                });
            })
            .catch(error => console.error('Error fetching deliveries:', error));
    }

    setInterval(fetchDeliveries, 6000);
    fetchDeliveries();
});
fetch('http://localhost:8080/students')
    .then(response => response.json())
    .then(data => {
        const tbody = document.getElementById('studentList');
        data.forEach(student => {
            const row = `
                    <tr>
                        <td>${student.studentId}</td>
                        <td>${student.name}</td>
                        <td>${student.stdNum}</td>
                        <td>${student.gender}</td>
                        <td>${student.grade}</td>
                        <td>${student.classNum}</td>
                        <td>${student.num}</td>
                    </tr>
                `;
            tbody.innerHTML += row;
        });
    });
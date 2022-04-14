import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from "axios";
import Button from '@mui/material/Button';

export default class FacultyList extends React.Component {

    state = {
        faculties: [],
        selection: []
    }

    columns = [
        { field: 'id', headerName: 'ID', width: 70 },
        { field: 'name', headerName: 'Name', width: 130 },
        ]

    componentDidMount() {
        axios.get('http://localhost:8080/faculties')
            .then(res => {
                const faculties = res.data;
                this.setState({ faculties });
            })
    }

    deleteOnClick() {
        let newFaculties = JSON.parse(JSON.stringify(this.state.faculties));
        this.state.selection.map((facultyId) => {
            axios.delete(`http://localhost:8080/faculties/${facultyId}`);
            newFaculties = newFaculties.filter((faculty) => {
                return faculty.id !== facultyId;
            });
        });
        this.setState({faculties: newFaculties});
    }

    addSelected(selection){
        this.setState({selection: selection})
    }

    render() {
        return (
            <div style={{ height: 400, width: '100%' }}>
                <DataGrid
                    rows={this.state.faculties}
                    columns={this.columns}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    checkboxSelection
                    onSelectionModelChange={(selectionModel) => this.addSelected(selectionModel)}
                />
                <Button onClick={() => this.deleteOnClick()}>Delete Selected</Button>
            </div>
        )
    }
}
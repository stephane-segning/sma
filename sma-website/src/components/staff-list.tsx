import {useStaff} from "../hooks/api-context/hook.ts";
import {useEffect, useState} from "react";
import {Staff} from "@rtb";

export function StaffList() {
    const [staffs, setStaffs] = useState<Staff[]>([]);
    const api = useStaff();

    useEffect(() => {
        api.getStaffs()
            .then((response) => {
                setStaffs(response.data);
            })
            .catch(reason => {
                console.error('Could not load staff', reason.message);
            });
    }, [api]);

    return (
        <div className="overflow-x-auto">
            <table className="table">
                <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Function</th>
                </tr>
                </thead>
                <tbody>
                {staffs.map((staff) => (
                    <tr key={staff.id}>
                        <th>{staff.id}</th>
                        <td>{staff.name}</td>
                        <td>{staff.functions?.join(', ')}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}